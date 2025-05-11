package com.example2.example;

	import java.util.ArrayDeque;

	// Implementa uma pilha usando ArrayDeque
	public class Pilha<T> {
	    private ArrayDeque<T> elementos = new ArrayDeque<>();

	    public void empilhar(T elemento) {
	        elementos.push(elemento);  // Insere no topo
	    }

	    public T desempilhar() {
	        if (estaVazia()) {
	            throw new IllegalStateException("Pilha vazia");
	        }
	        return elementos.pop(); // Remove do topo
	    }

	    public T topo() {
	        if (estaVazia()) {
	            throw new IllegalStateException("Pilha vazia");
	        }
	        return elementos.peek(); // Consulta o topo sem remover
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