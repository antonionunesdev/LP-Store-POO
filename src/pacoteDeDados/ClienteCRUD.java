package pacoteDeDados;

import java.util.ArrayList;
import java.util.List;
import pacoteDeNegocios.Cliente;

public class ClienteCRUD {
    private List<Cliente> listaClientes;

    public ClienteCRUD() {
        this.listaClientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
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

    public List<Cliente> listarClientes() {
        return listaClientes;
    }
}