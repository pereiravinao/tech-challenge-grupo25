package com.br.arraydesabores.rede.application.usecases.address;

import com.br.arraydesabores.rede.application.exception.AddressNotFoundException;
import com.br.arraydesabores.rede.application.interfaces.IAddressGateway;
import com.br.arraydesabores.rede.domain.model.User;
import com.br.arraydesabores.rede.infrastructure.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAddressUseCase {

    private final IAddressGateway addressGateway;
    private final ModelMapper modelMapper;

    public void execute(Long id) {
        var userAuth = SecurityUtils.getCurrentUserAuth();

        var address = addressGateway.findByIdAndUserId(id, userAuth.getId());

        addressGateway.deleteById(address.getId());
    }
}
