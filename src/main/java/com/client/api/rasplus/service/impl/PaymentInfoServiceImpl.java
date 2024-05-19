package com.client.api.rasplus.service.impl;

import com.client.api.rasplus.dto.PaymentProcessDto;
import com.client.api.rasplus.exception.BusinessException;
import com.client.api.rasplus.exception.NotFoundException;
import com.client.api.rasplus.integration.RaspayIntegration;
import com.client.api.rasplus.mapper.client.CreditCardMapper;
import com.client.api.rasplus.mapper.client.CustomerMapper;
import com.client.api.rasplus.mapper.UserPaymentInfoMapper;
import com.client.api.rasplus.mapper.client.OrderMapper;
import com.client.api.rasplus.mapper.client.PaymentMapper;
import com.client.api.rasplus.model.User;
import com.client.api.rasplus.repository.UserPaymentInfoRepository;
import com.client.api.rasplus.repository.UserRepository;
import com.client.api.rasplus.service.PaymentInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentInfoServiceImpl implements PaymentInfoService {

    private final RaspayIntegration integration;
    private final UserRepository userRepository;
    private final UserPaymentInfoRepository paymentInfoRepository;

    @Override
    public Boolean process(PaymentProcessDto dto) {
        // verifica usuario por id e verifica assinatura
        var user = validaUsuario(dto.getUserPaymentInfo().getUserId());

        // cria ou atualiza usuario raspay
        var customer = integration.createCustomer(CustomerMapper.build(user));

        // cria pedido de pagamento
        var orderDto = integration.createOrder(OrderMapper.build(customer.getId(), dto));

        // processa o pagamento
        var creditCard = CreditCardMapper.build(dto.getUserPaymentInfo(), user.getCpf());
        var payment = integration.processPayment(PaymentMapper.build(customer.getId(), orderDto.getId(), creditCard));

        // salva informações de pagamento
        if (payment){
            var userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfo(), user);
            paymentInfoRepository.save(userPaymentInfo);
        }

        return null;
    }

    private User validaUsuario(Long userId) {
        var userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        var user = userOpt.get();
        if (user.getSubscriptionType() != null){
            throw new BusinessException("Pagamento não pode ser processado pois usuário já possui assinatura");
        }

        return user;
    }
}
