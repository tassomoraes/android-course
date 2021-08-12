package com.tlom.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch; 	// classe para criar animações
	private Texture[] passaros;
	private Texture fundo;	// plano de fundo

	// Atributos de configuração
	private float variacao = 0;
	private int largura_tela;
	private int altura_tela;

	// Para inicializar o jogo
	@Override
	public void create () {

		batch = new SpriteBatch();
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");
		fundo = new Texture("fundo.png");

		// getWidth recupera a largura da tela e getHight peda a altura
		largura_tela = Gdx.graphics.getWidth();
		altura_tela = Gdx.graphics.getHeight();

	}

	// Para as animações
	@Override
	public void render () {

		// para o passaro se mover na tela
		variacao += Gdx.graphics.getDeltaTime() * 10;	// pega o tempo entre um render e outra
		if(variacao > 2) variacao = 0;

		// para exibir alguma textura
		batch.begin();

		batch.draw(fundo, 0,0, largura_tela, altura_tela);
		// colocar textura passaro na posição x,y
		batch.draw(passaros[(int)variacao], 30, altura_tela / 2);

		batch.end();

	}

}