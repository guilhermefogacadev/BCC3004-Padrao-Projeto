public interface ItemMenu {
    void exibir();
}

public class ItemSimples implements ItemMenu {
    private String nome;
    private double preco;

    public ItemSimples(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void exibir() {
        System.out.println("Item: " + nome + " - Preço: R$ " + preco);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemMenu {
    private String nome;
    private List<ItemMenu> itens = new ArrayList<>();

    public Combo(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
    }

    public void removerItem(ItemMenu item) {
        itens.remove(item);
    }

    @Override
    public void exibir() {
        System.out.println("Combo: " + nome);
        for (ItemMenu item : itens) {
            item.exibir();
        }
    }
}


public class Main {
    public static void main(String[] args) {

        ItemSimples hamburguer = new ItemSimples("Hambúrguer", 15.00);
        ItemSimples refrigerante = new ItemSimples("Refrigerante", 5.00);
        ItemSimples batataFrita = new ItemSimples("Batata Frita", 7.00);

   
        Combo comboFamiliar = new Combo("Combo Familiar");
        comboFamiliar.adicionarItem(hamburguer);
        comboFamiliar.adicionarItem(refrigerante);
        comboFamiliar.adicionarItem(batataFrita);

        Combo comboEspecial = new Combo("Combo Especial");
        comboEspecial.adicionarItem(comboFamiliar); 
        comboEspecial.adicionarItem(new ItemSimples("Sobremesa", 8.00));


        comboEspecial.exibir();
    }
}

