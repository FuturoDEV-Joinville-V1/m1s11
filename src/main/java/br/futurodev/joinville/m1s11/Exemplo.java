package br.futurodev.joinville.m1s11;

import br.futurodev.joinville.m1s11.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s11.entities.User;
import br.futurodev.joinville.m1s11.services.UserService;
import br.futurodev.joinville.m1s11.services.UserServiceImpl;

import java.util.List;

public class Exemplo {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("jle");
        user.setPassword("123456");
        user.setName("Joville");


        UserService service = new UserServiceImpl(null, null);
        // ☝️Bean

        // Conecta no DB
        // Inicializa o Servlet (REST)
        // Segurança (filterChain)
        // - Qual o tipo de autenticação? Basic
        // - Onde eu cadastro o usuário? user/56142387619823-12398789123-1293818923
        // - Como eu sei encontrar ele? Na memória ver se o usuário existe


        List<UserResponseDto> users = service.findAll();

//        service.save();

    }
}
