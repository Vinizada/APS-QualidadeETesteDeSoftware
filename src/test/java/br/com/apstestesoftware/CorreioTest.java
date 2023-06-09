package br.com.apstestesoftware;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import br.com.apstestesoftware.entities.CorreioService;

public class CorreioTest {

	@Test
	public void testBuscaEndereco() {
		CorreioService correioServiceMock = mock(CorreioService.class);

		when(correioServiceMock.buscaEndereco("9000000")).thenReturn("Porto Alegre");
		when(correioServiceMock.buscaEndereco("8000000")).thenReturn("Av. Assis Brasil");

		String endereco1 = correioServiceMock.buscaEndereco("9000000");
		String endereco2 = correioServiceMock.buscaEndereco("8000000");

		assertEquals("Porto Alegre", endereco1);
		assertEquals("Av. Assis Brasil", endereco2);

		verify(correioServiceMock).buscaEndereco("9000000");
		verify(correioServiceMock).buscaEndereco("8000000");
	}

}
