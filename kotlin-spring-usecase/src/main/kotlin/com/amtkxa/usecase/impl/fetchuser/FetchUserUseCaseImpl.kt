package com.amtkxa.usecase.impl.fetchuser

import com.amtkxa.domain.repository.UserRepository
import com.amtkxa.usecase.specification.UserSpecifications.Companion.countryContains
import com.amtkxa.usecase.specification.UserSpecifications.Companion.nameContains
import org.springframework.data.jpa.domain.Specifications
import org.springframework.stereotype.Service

@Service
class FetchUserUseCaseImpl(private val userRepository: UserRepository) : FetchUserUseCase {

    override fun execute(request: FetchUserRequest, response: FetchUserResponse) {
        val userList = userRepository.findAll(Specifications
                .where(nameContains(request.name))
                .and(countryContains(request.country))
        )
        response.setUserList(userList)
    }
}