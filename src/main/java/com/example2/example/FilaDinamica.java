package com.example2.example;

import java.util.LinkedList;

//Implementa uma fila dinâmica usando LinkedList
public class FilaDinamica<T> {
    private LinkedList<T> elementos = new LinkedList<>();

    public void enfileirar(T elemento) {
        elementos.addLast(elemento); 
    }  // Adiciona ao fim da fila

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        return elementos.removeFirst(); // Remove do início da fila
    }

    public boolean estaVazia() {
        return elementos.isEmpty();
    }

    public void limpar() {
        elementos.clear();
    }

    public int tamanho() {
        return elementos.size();
    }
}
