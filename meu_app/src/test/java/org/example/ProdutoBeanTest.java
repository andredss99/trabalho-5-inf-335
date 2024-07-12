package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBeanTest {

    private ProdutoBean produto;

    @BeforeEach
    void setUp() {
        this.produto = new ProdutoBean(
                "COD_TEST",
                "NOME_TEST",
                "DESC_TEST",
                123.54,
                "NOVO"
        );
    }

    @Test
    void testConstrutorSemParametros() {
        ProdutoBean produto = new ProdutoBean();

        assertInstanceOf(String.class, produto.getCodigo());
        assertInstanceOf(String.class, produto.getNome());
        assertInstanceOf(String.class, produto.getDescricao());
        assertInstanceOf(String.class, produto.getEstado());
        assertEquals(0.0, produto.getValor());
    }

    @Test
    void testCodigo() {
        ProdutoBean produto = new ProdutoBean();
        produto.setCodigo("UNIT_TEST");
        assertEquals("UNIT_TEST", produto.getCodigo());

        assertEquals("COD_TEST", this.produto.getCodigo());
    }

    @Test
    void testNome() {
        ProdutoBean produto = new ProdutoBean();
        produto.setNome("UNIT_TEST");
        assertEquals("UNIT_TEST", produto.getNome());

        assertEquals("NOME_TEST", this.produto.getNome());
    }


    @Test
    void testDescricao() {
        ProdutoBean produto = new ProdutoBean();
        produto.setDescricao("UNIT_TEST");
        assertEquals("UNIT_TEST", produto.getDescricao());

        assertEquals("DESC_TEST", this.produto.getDescricao());
    }

    @Test
    void testValor() {
        Random r = new Random();

        ProdutoBean produto = new ProdutoBean();
        double valor = r.nextDouble() * 100;

        produto.setValor(valor);
        assertEquals(valor, produto.getValor());

        assertEquals(123.54, this.produto.getValor());
    }

    @Test
    void testEstado() {
        ProdutoBean produto = new ProdutoBean();
        produto.setEstado("UNIT_TEST");
        assertEquals("UNIT_TEST", produto.getEstado());

        assertEquals("NOVO", this.produto.getEstado());
    }

    @Test
    void testSerialversionuid() {
        ProdutoBean produto = new ProdutoBean();
        assertEquals(1L, ProdutoBean.getSerialversionuid());
    }

    @ParameterizedTest
    @CsvSource({
        "10.0, 5.0, 1",
        "5.0, 10.0, -1",
        "7.0, 7.0, 0",
        "0.0, 0.0, 0",
        "-5.0, 0.0, -1",
        "0.0, -5.0, 1",
        "3.1415, 3.1415, 0",
        "2.7182, 3.1415, -1",
        "3.1415, 2.7182, 1"
    })
    void testCompareTo(double valor1, double valor2, int resultadoEsperado) {
        ProdutoBean produto1 = new ProdutoBean();
        produto1.setValor(valor1);

        ProdutoBean produto2 = new ProdutoBean();
        produto2.setValor(valor2);

        assertEquals(resultadoEsperado, produto1.compareTo(produto2));
    }
}