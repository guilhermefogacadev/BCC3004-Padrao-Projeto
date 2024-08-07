interface Mediator {
    void enviarMensagem(String mensagem, Usuario remetente);
}

class BatePapo implements Mediator {
    private Map<String, Usuario> usuarios = new HashMap<>();

    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNome(), usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        for (Usuario usuario : usuarios.values()) {
            if (!usuario.equals(remetente)) {
                usuario.receberMensagem(mensagem);
            }
        }
    }
}

class Usuario {
    private String nome;
    private Mediator mediator;

    public Usuario(String nome, Mediator mediator) {
        this.nome = nome;
        this.mediator = mediator;
    }

    public void enviarMensagem(String mensagem) {
        mediator.enviarMensagem(mensagem, this);
    }

    public void receberMensagem(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
}

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new BatePapo();

        Usuario usuario1 = new Usuario("Alice", mediator);
        Usuario usuario2 = new Usuario("Bob", mediator);

        mediator.registrarUsuario(usuario1);
        mediator.registrarUsuario(usuario2);

        usuario1.enviarMensagem("Olá, mundo!");
    }
}
