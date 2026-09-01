package com.template.validator;

//interface usada para OCP
//O T é um tipo genérico, não se importanto se é int, string, ele vai se tornar do tipo do valor mandado
public interface Validador<T> {

    /*isso é uma interface. Repare que se eu criar um paaametro do tipo dessa interface, voce pode enviar qualquer
    objeto das classes que a implementam. */


    boolean validar(T valor);
    String getMensagemErro();
    T getValor();
}
