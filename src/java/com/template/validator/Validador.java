package com.template.validator;

//interface usada para OCP
//O T é um tipo genérico, não se importanto se é int, string, ele vai se tornar do tipo do valor mandado
public interface Validador<T> {

    boolean validar(T valor);
    String getMensagemErro();
    T getValor();
}
