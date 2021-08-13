package com.tlom.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch; 	// classe para criar animações
	private Texture[] passaros;
	private Texture fundo;	// plano de fundo
	private Texture cano_baixo;
	private Texture cano_topo;
	private Random numero_randomico;

	// Atributos de configuração
	private int largura_tela;
	private int altura_tela;

	private float variacao = 0;
	private float velocidade_queda = 0;
	private float posicao_inicial_vertical;
	private float posicao_cano_movimento_horizontal;
	private float espaço_entre_canos;
	private float delta_time;
	private float altura_entre_canos_randomica;
	private float movimentoY_cano_topo;
	private float movimentoY_cano_baixo;

	private double largura_passaro;
	private double altura_passaro;
	private double largura_cano;
	private double altura_cano;

	// Para inicializar o jogo
	@Override
	public void create () {

		numero_randomico = new Random();

		batch = new SpriteBatch();
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");
		cano_baixo = new Texture("cano_baixo.png");
		cano_topo = new Texture("cano_topo.png");

		// getWidth recupera a largura da tela e getHight peda a altura
		largura_tela = Gdx.graphics.getWidth();
		altura_tela = Gdx.graphics.getHeight();

		posicao_inicial_vertical = altura_tela / 2;

		posicao_cano_movimento_horizontal = largura_tela;
		espaço_entre_canos = 200;

	}

	// Para as animações
	@Override
	public void render () {

		delta_time = Gdx.graphics.getDeltaTime();

		// para o passaro se mover na tela
		variacao += delta_time * 10;	// pega o tempo entre um render e outra
		posicao_cano_movimento_horizontal -= delta_time * 200;
		velocidade_queda++;

		if(variacao > 2) variacao = 0;

		// evento de click
		if( Gdx.input.justTouched() ){
			velocidade_queda = -15;
		}

		// reniciando posição do cano verificando se saiu inteiramente da tela
		if ( posicao_cano_movimento_horizontal < -cano_topo.getWidth()) {
			posicao_cano_movimento_horizontal = largura_tela;
			altura_entre_canos_randomica = numero_randomico.nextInt(800) - 300;
		}

		if(posicao_inicial_vertical > 0 || posicao_inicial_vertical < 0)
			posicao_inicial_vertical -= velocidade_queda;

		// para exibir alguma textura
		batch.begin();

		// colocar textura na posição x,y
		batch.draw(fundo, 0,0, largura_tela, altura_tela);
		// redimencionando canos
		largura_cano = cano_topo.getWidth()*1.8;
		altura_cano = cano_topo.getHeight()*1.8;
		// movimento do cano
		movimentoY_cano_topo = altura_tela/2 + espaço_entre_canos/2 + altura_entre_canos_randomica;
		movimentoY_cano_baixo = altura_tela/2 - cano_baixo.getHeight() - espaço_entre_canos/2 + altura_entre_canos_randomica;
		batch.draw(cano_topo, posicao_cano_movimento_horizontal, movimentoY_cano_topo, (float)largura_cano, (float)altura_cano);
		batch.draw(cano_baixo, posicao_cano_movimento_horizontal, movimentoY_cano_baixo, (float)largura_cano, (float)altura_cano);

		largura_passaro = passaros[(int)variacao].getWidth()*1.8;
		altura_passaro = passaros[(int)variacao].getHeight()*1.8;
		batch.draw(passaros[(int)variacao], 120, posicao_inicial_vertical, (float)largura_passaro, (float)altura_passaro);

		batch.end();

	}

}
