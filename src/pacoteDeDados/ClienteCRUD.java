package pacoteDeDados;

import java.util.ArrayList;
import java.util.List;
import pacoteDeNegocios.Cliente;

public class ClienteCRUD {
    private final List<Cliente> listaClientes;

    public ClienteCRUD() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String senha) {
        Cliente cliente = new Cliente(nome, senha);
        listaClientes.add(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePorId(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }
}