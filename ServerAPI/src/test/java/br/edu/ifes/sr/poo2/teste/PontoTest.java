package br.edu.ifes.sr.poo2.teste;


public class PontoTest {

	/*private GerenteAPI gerenteAPI;
	
	private JogadorAPI jogadorAPI;
	
	private ServicoAPI servicoAPI;
	
	private PontoAPI pontoAPI;
	
	private Gerente gerente = new Gerente();
	
	private Categoria categoria =  new Categoria();
	
	private Jogador jogador = new Jogador();
	
	private Servico servico = new Servico();
	
	private Ranking ranking = new Ranking();
	
	@Before
	public void before()
	{
		categoriaAPI = new CategoriaAPIIMpl();
		
		gerenteAPI = new GerenteAPIIMpl();
		
		jogadorAPI = new JogadorAPIIMpl();
		
		servicoAPI = new ServicoAPIIMpl();
		
		pontoAPI = new PontoAPIIMpl();
		
		//Criando o servico
		servico.setUrl("http://xxxxx");
		
		//Gerente
		gerente.setEmail(UUID.randomUUID().toString());
		gerente.setSenha("XXXX");
		
		//Criando a categoria
		categoria.setDescricao("CategoriaX");
		categoria.setNome("XXXX");
		
		//Criando o jogador
		jogador.setEmail(UUID.randomUUID().toString());
		jogador.setSenha("1234");
		jogador.setUsername(UUID.randomUUID().toString());
		
	}
	
	@Test
	public void adicionarponto() throws Exception
	{
		//adicionando o jogador
		jogadorAPI.adicionar(jogador);
		
		//Criando o gerente
		int idGerente = gerenteAPI.adicionar(gerente);
		//Criando a categoria
		int idCategoria = categoriaAPI.adicionar(categoria);
		
		servico.setIdCategoria(idCategoria);
		servico.setIdGerente(idGerente);
		
		//Adicionando o servico
		int idServico = servicoAPI.adicionar(servico);
		
		Assert.assertNotSame(idServico, 0);
		
		Ponto ponto = new Ponto();
		
		ponto.setIdServico(idServico);
		
		ponto.setUserName(jogador.getUsername());
		
		ponto.setValor(10);
		
		//Adicionando o ponto
		pontoAPI.setPonto(ponto);
	}
	
	*/
}
