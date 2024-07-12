package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioBeanTest {
    private AnuncioBean anuncio;

    @BeforeEach
    void setUp() {
        this.anuncio = new AnuncioBean(
            new ProdutoBean(),
            new ArrayList<URL>(),
            0.5
        );
    }

    @Test
    void testConstrutorSemParametros() {
        AnuncioBean anuncio = new AnuncioBean();

        assertInstanceOf(ProdutoBean.class, anuncio.getProduto());
        assertInstanceOf(ArrayList.class, anuncio.getFotosUrl());
        assertEquals(0, anuncio.getFotosUrl().size());
        assertEquals(0.0, anuncio.getDesconto());
    }

    @Test
    void testProduto() {
        AnuncioBean anuncio = new AnuncioBean();
        ProdutoBean produto = new ProdutoBean();

        anuncio.setProduto(produto);
        assertEquals(produto, anuncio.getProduto());
        assertInstanceOf(ProdutoBean.class, anuncio.getProduto());
    }

    @Test
    void testFotosUrl() {
        AnuncioBean anuncio = new AnuncioBean();
        ArrayList<URL> fotosUrl = new ArrayList<URL>();

        anuncio.setFotosUrl(fotosUrl);
        assertEquals(fotosUrl, anuncio.getFotosUrl());
        assertInstanceOf(ArrayList.class, anuncio.getFotosUrl());
        assertEquals(0, anuncio.getFotosUrl().size());
    }

    @Test
    void testDesconto() {
        Random r = new Random();

        AnuncioBean anuncio = new AnuncioBean();
        Double desconto = r.nextDouble();

        anuncio.setDesconto(desconto);
        assertEquals(desconto, anuncio.getDesconto());
        assertInstanceOf(Double.class, anuncio.getDesconto());
    }

    @Test
    void testSerialversionuid() {
        AnuncioBean anuncio = new AnuncioBean();
        assertEquals(1L, AnuncioBean.getSerialversionuid());
    }

    @ParameterizedTest
    @CsvSource({
        "100.0, 0.0, 100.0",
        "100.0, 0.5, 50.0",
        "100.0, 1.0, 0.0",
        "200.0, 0.25, 150.0",
        "50.0, 0.1, 45.0",
        "75.0, 0.3, 52.5"
    })
    void testValor(Double valorProduto, Double desconto, Double valorFinalEsperado) {
        ProdutoBean produto = new ProdutoBean();
        produto.setValor(valorProduto);

        AnuncioBean anuncio = new AnuncioBean();
        anuncio.setProduto(produto);
        anuncio.setDesconto(desconto);

        assertEquals(valorFinalEsperado, anuncio.getValor());
    }


}