package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {
    private AnuncianteBean anunciante;

    @BeforeEach
    void setUp() {
        this.anunciante = new AnuncianteBean(
            "UNIT_TEST",
            "UNIT_TEST",
            new ArrayList<AnuncioBean>()
        );
    }

    @Test
    void testConstrutorSemParametros() {
        AnuncianteBean anunciante = new AnuncianteBean();

        assertInstanceOf(String.class, anunciante.getNome());
        assertInstanceOf(String.class, anunciante.getCPF());
        assertInstanceOf(ArrayList.class, anunciante.getAnuncios());
        assertEquals(0, anunciante.getAnuncios().size());
    }

    @Test
    void testNome() {
        AnuncianteBean anunciante = new AnuncianteBean();
        String nome = "UNIT_TEST";

        anunciante.setNome(nome);
        assertEquals(nome, anunciante.getNome());

        assertEquals("UNIT_TEST", this.anunciante.getNome());
    }

    @Test
    void testCPF() {
        AnuncianteBean anunciante = new AnuncianteBean();
        String CPF = "UNIT_TEST";

        anunciante.setCPF(CPF);
        assertEquals(CPF, anunciante.getCPF());

        assertEquals(CPF, this.anunciante.getCPF());
    }

    @Test
    void testAnuncios() {
        AnuncianteBean anunciante = new AnuncianteBean();
        ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();

        anunciante.setAnuncios(anuncios);
        assertEquals(anuncios, anunciante.getAnuncios());
        assertEquals(0, anunciante.getAnuncios().size());
        assertInstanceOf(ArrayList.class, anunciante.getAnuncios());
    }

    @Test
    void testAddAnuncio() {
        AnuncioBean anuncio1 = new AnuncioBean();
        AnuncioBean anuncio2 = new AnuncioBean();

        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);

        assertInstanceOf(ArrayList.class, anunciante.getAnuncios());
        assertEquals(2, anunciante.getAnuncios().size());
    }

    @Test
    void testRemoveAnuncio() {
        AnuncioBean anuncio1 = new AnuncioBean();
        AnuncioBean anuncio2 = new AnuncioBean();
        AnuncioBean anuncio3 = new AnuncioBean();

        ArrayList<AnuncioBean> listaAnuncios = new ArrayList<AnuncioBean>();
        listaAnuncios.add(anuncio1);

        AnuncianteBean anunciante = new AnuncianteBean();

        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        anunciante.addAnuncio(anuncio3);

        anunciante.removeAnuncio(2);
        anunciante.removeAnuncio(1);

        assertEquals(listaAnuncios, anunciante.getAnuncios());
        assertEquals(1, anunciante.getAnuncios().size());
    }

    @Test
    void testRemoveAnuncioIndiceInexistente() {
        AnuncioBean anuncio1 = new AnuncioBean();
        AnuncioBean anuncio2 = new AnuncioBean();
        AnuncioBean anuncio3 = new AnuncioBean();

        ArrayList<AnuncioBean> listaAnuncios = new ArrayList<AnuncioBean>();
        listaAnuncios.add(anuncio1);

        AnuncianteBean anunciante = new AnuncianteBean();

        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        anunciante.addAnuncio(anuncio3);

        assertThrows(IndexOutOfBoundsException.class, () -> anunciante.removeAnuncio(5));
    }

    @Test
    void testValorMedioAnuncio() {
        ProdutoBean produto1 = new ProdutoBean();
        produto1.setValor(100.0);

        ProdutoBean produto2 = new ProdutoBean();
        produto2.setValor(200.0);

        ProdutoBean produto3 = new ProdutoBean();
        produto3. setValor(1000.0);

        AnuncioBean anuncio1 = new AnuncioBean();
        anuncio1.setProduto(produto1);
        anuncio1.setDesconto(0.5); //50

        AnuncioBean anuncio2 = new AnuncioBean();
        anuncio2.setProduto(produto2);
        anuncio2.setDesconto(0.6); //80

        AnuncioBean anuncio3 = new AnuncioBean();
        anuncio3.setProduto(produto3);
        anuncio3.setDesconto(0.5); //500

        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        anunciante.addAnuncio(anuncio3);

        assertEquals(210.0, anunciante.valorMedioAnuncios());
    }
}