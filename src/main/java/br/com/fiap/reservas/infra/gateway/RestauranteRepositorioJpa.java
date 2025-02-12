package br.com.fiap.reservas.infra.gateway;

import br.com.fiap.reservas.entities.EnderecoEntity;
import br.com.fiap.reservas.entities.RestauranteEntity;
import br.com.fiap.reservas.infra.repository.Restaurante;
import br.com.fiap.reservas.infra.repository.RestauranteRepository;
import br.com.fiap.reservas.interfaces.IRestauranteGateway;

import java.time.LocalDateTime;

public class RestauranteRepositorioJpa implements IRestauranteGateway {

    private final RestauranteRepository restauranteRepository;

    public RestauranteRepositorioJpa(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public RestauranteEntity buscarRestaurantePorNomeELocalizacaoETipo(String nome, String endereco, String tipo) {
        Restaurante restaurante = restauranteRepository.findByNomeAndEnderecoAndTipo(nome, endereco, tipo);

        EnderecoEntity enderecoEntity = new EnderecoEntity("123", "456", "789", "101112",
                "123", "123");

        return new RestauranteEntity(restaurante.getNome(), enderecoEntity, restaurante.getTipo(), LocalDateTime.now(),
                LocalDateTime.now(), 10);
    }
}
