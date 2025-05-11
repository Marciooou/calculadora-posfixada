package com.example2.example;
import com.example2.example.FilaDinamica;
import com.example2.example.Pilha;
import org.springframework.stereotype.Service;

//Classe de serviço responsável por calcular a expressão pós-fixada
@Service
public class PostfixCalculatorService {

    public double calcularExpressao(String expressao) {
        FilaDinamica<String> fila = new FilaDinamica<>(); // Fila com os tokens
        Pilha<Double> pilha = new Pilha<>(); // Pilha para cálculo
    
        // Quebra a expressão em tokens e enfileira cada um
        for (String token : expressao.trim().split("\\s+")) {
            fila.enfileirar(token);
        }

     // Processa os tokens da fila
        while (!fila.estaVazia()) {
            String token = fila.desenfileirar();
            if (isOperando(token)) {
                pilha.empilhar(Double.parseDouble(token));  // Se número, empilha
            } else if (isOperador(token)) {
            	// Verifica se há operandos suficientes
                if (pilha.tamanho() < 2) {
                    throw new IllegalArgumentException("Expressão malformada: operandos insuficientes.");
                }
             // Desempilha dois operandos e aplica a operação
                double b = pilha.desempilhar();
                double a = pilha.desempilhar();
                pilha.empilhar(calcular(a, b, token)); // Empilha resultado
            } else {
                throw new IllegalArgumentException("Operador inválido: " + token);
            }
        }

        // Após o processamento, a pilha deve conter exatamente um valor (o resultado)
        if (pilha.tamanho() != 1) {
            throw new IllegalArgumentException("Expressão malformada: operandos ou operadores em excesso.");
        }

        return pilha.desempilhar();
    }
    // Verifica se o token é um número válido
    private boolean isOperando(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
 // Verifica se o token é um operador válido
    private boolean isOperador(String token) {
        return "+-*/%".contains(token) && token.length() == 1;
    }
 // Realiza a operação aritmética
    private double calcular(double a, double b, String operador) {
        return switch (operador) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Divisão por zero.");
                yield a / b;
            }
            case "%" -> {
                if (b == 0) throw new ArithmeticException("Módulo por zero.");
                yield a % b;
            }
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}