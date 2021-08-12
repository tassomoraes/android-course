package com.tlom.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch; 	// classe para criar animações
	private Texture passaro;
	private Texture fundo;	// plano de fundo

	// Atributos de configuração
	private int movimento = 0;
	private int largura_tela;
	private int altura_tela

	// Para inicializar o jogo
	@Override
	public void create () {

		batch = new SpriteBatch();
		passaro = new Texture("passaro1.png");
		fundo = new Texture("fundo.png");

		// getWidth recupera a largura da tela e getHight peda a altura
		largura_tela = Gdx.graphics.getWidth();
		altura_tela = Gdx.graphics.getHeight();

	}

	// Para as animações
	@Override
	public void render () {

		// para o passaro se mover na tela
		movimento++;

		// para exibir alguma textura
		batch.begin();

		batch.draw(fundo, 0,0, largura_tela, altura_tela);
		// colocar textura passaro na posição x,y
		batch.draw(passaro, movimento, 400);

		batch.end();

	}

}
