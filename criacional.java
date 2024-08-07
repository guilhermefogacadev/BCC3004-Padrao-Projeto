public interface Notificacao {
    void notificarUsuario();
}

public class NotificacaoEmail implements Notificacao {
    @Override
    public void notificarUsuario() {
        System.out.println("Enviando uma notificação por Email...");
    }
}

public class NotificacaoSMS implements Notificacao {
    @Override
    public void notificarUsuario() {
        System.out.println("Enviando uma notificação por SMS...");
    }
}


public abstract class FabricaNotificacao {
    public void enviarNotificacao() {
        Notificacao notificacao = criarNotificacao();
        notificacao.notificarUsuario();
    }

    protected abstract Notificacao criarNotificacao();
}



public class FabricaNotificacaoEmail extends FabricaNotificacao {
    @Override
    protected Notificacao criarNotificacao() {
        return new NotificacaoEmail();
    }
}

public class FabricaNotificacaoSMS extends FabricaNotificacao {
    @Override
    protected Notificacao criarNotificacao() {
        return new NotificacaoSMS();
    }
}


public class Main {
    public static void main(String[] args) {
        FabricaNotificacao fabricaEmail = new FabricaNotificacaoEmail();
        FabricaNotificacao fabricaSMS = new FabricaNotificacaoSMS();

        fabricaEmail.enviarNotificacao(); 
        fabricaSMS.enviarNotificacao();   
    }
}
