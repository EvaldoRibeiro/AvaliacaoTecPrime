package com.tecprime.avaliacaotecprime;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tecprime.avaliacaotecprime.domain.Categoria;
import com.tecprime.avaliacaotecprime.domain.Cidade;
import com.tecprime.avaliacaotecprime.domain.Cliente;
import com.tecprime.avaliacaotecprime.domain.Endereco;
import com.tecprime.avaliacaotecprime.domain.Estado;
import com.tecprime.avaliacaotecprime.domain.ItemPedido;
import com.tecprime.avaliacaotecprime.domain.Pagamento;
import com.tecprime.avaliacaotecprime.domain.PagamentoComBoleto;
import com.tecprime.avaliacaotecprime.domain.PagamentoComCartao;
import com.tecprime.avaliacaotecprime.domain.Pedido;
import com.tecprime.avaliacaotecprime.domain.Produto;
import com.tecprime.avaliacaotecprime.domain.enums.EstadoPagamento;
import com.tecprime.avaliacaotecprime.domain.enums.TipoCliente;
import com.tecprime.avaliacaotecprime.repositories.CategoriaRepository;
import com.tecprime.avaliacaotecprime.repositories.CidadeRepository;
import com.tecprime.avaliacaotecprime.repositories.ClienteRepository;
import com.tecprime.avaliacaotecprime.repositories.EnderecoRepository;
import com.tecprime.avaliacaotecprime.repositories.EstadoRepository;
import com.tecprime.avaliacaotecprime.repositories.ItemPedidoRepository;
import com.tecprime.avaliacaotecprime.repositories.PagamentoRepository;
import com.tecprime.avaliacaotecprime.repositories.PedidoRepository;
import com.tecprime.avaliacaotecprime.repositories.ProdutoRepository;

@SpringBootApplication
public class AvalicaotecprimeApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AvalicaotecprimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Alimentação");
		
		Produto p1 = new Produto(null, "Hambúrgueres", 20.00);
		Produto p2 = new Produto(null, "Porções", 80.00);
		Produto p3 = new Produto(null, "Sucos", 8.00);
		Produto p4 = new Produto(null, "Refrigerantes", 12.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p3, p4));
		cat2.getProdutos().addAll(Arrays.asList(p1, p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat2));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		Cliente cli1 = new Cliente(null, "Isabel Cristina", "isabel@gmail.com", "56108648015", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32113345", "34988440993"));
		
		Cliente cli2 = new Cliente(null, "Sara Costa", "sara.gomes@gmail.com", "66368817046", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32113360", "34991763673"));
		
		Endereco e1 = new Endereco(null, "Flores", "300", "Apt 303", "Jardim", "38400000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38400001", cli1, c2);
		Endereco e3 = new Endereco(null, "Avenida Floriano", "2105", null, "Centro", "38400010", cli2, c2);
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2019 19:37"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2019 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));  
		
		ItemPedido ip1 = new ItemPedido(ped1, p4, 0.00, 5, 20.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 6, 8.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 0.00, 4, 80.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
			
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
