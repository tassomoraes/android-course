package com.tlom.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch batch; 	// classe para criar animações
	private Texture[] passaros;
	private Texture fundo;	// plano de fundo
	private Texture cano_baixo;
	private Texture cano_topo;
	private Texture game_over;
	private Random numero_randomico;
	private BitmapFont fonte;
	private BitmapFont menssagem;
	private Circle passaro_circulo;
	private Rectangle retangulo_cano_topo;
	private Rectangle retangulo_cano_baixo;
	//private ShapeRenderer shape;

	// Atributos de configuração
	private int largura_tela;
	private int altura_tela;
	private int estatado_jogo = 0; // 0 > não iniciado	1 > iniciado	2 > Game Over
	private int pontuacao = 0;

	private boolean marcou_ponto = false;

	private float variacao = 0;
	private float velocidade_queda = 0;
	private float posicao_inicial_vertical;
	private float posicao_cano_movimento_horizontal;
	private float espaço_entre_canos;
	private float delta_time;
	private float altura_entre_canos_randomica;
	private float movimentoY_cano_topo;
	private float movimentoY_cano_baixo;

	private double escala = 1.8;	// para almentar as imagens em 80% do tamanho original
	private double largura_passaro;
	private double altura_passaro;
	private double largura_cano;
	private double altura_cano;
	private double largura_game_over;
	private double altura_game_over;

	// Para inicializar o jogo
	@Override
	public void create () {

		numero_randomico = new Random();
		passaro_circulo = new Circle();
		retangulo_cano_topo = new Rectangle();
		retangulo_cano_baixo = new Rectangle();
		//shape = new ShapeRenderer();
		fonte = new BitmapFont();
		fonte.setColor(Color.WHITE);
		fonte.getData().setScale(10);

		menssagem = new BitmapFont();
		menssagem.setColor(Color.WHITE);
		menssagem.getData().setScale(6);

		batch = new SpriteBatch();

		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");
		cano_baixo = new Texture("cano_baixo.png");
		cano_topo = new Texture("cano_topo.png");

		game_over = new Texture("game_over.png");

		// getWidth recupera a largura da tela e getHight peda a altura
		largura_tela = Gdx.graphics.getWidth();
		altura_tela = Gdx.graphics.getHeight();

		posicao_inicial_vertical = altura_tela/2;

		posicao_cano_movimento_horizontal = largura_tela;
		espaço_entre_canos = 900;

	}

	// Para as animações
	@Override
	public void render () {


		delta_time = Gdx.graphics.getDeltaTime();    // pega o tempo entre um render e outra
		variacao += delta_time * 10; // para o passaro se mover na tela
		if (variacao > 2) variacao = 0;

		// redimencionando figuras
		// canos
		largura_cano = cano_topo.getWidth()*escala;
		altura_cano = cano_topo.getHeight()*escala;
		// passaro
		largura_passaro = passaros[(int)variacao].getWidth()*escala;
		altura_passaro = passaros[(int)variacao].getHeight()*escala;
		// game over
		largura_game_over = game_over.getWidth()*escala;
		altura_game_over = game_over.getHeight()*escala;

		if ( estatado_jogo == 0 ){
			if (Gdx.input.justTouched()){
				estatado_jogo = 1;
			}
		}else {

			velocidade_queda++;
			if (posicao_inicial_vertical > 0 || velocidade_queda < 0)
				posicao_inicial_vertical -= velocidade_queda;

			if ( estatado_jogo == 1 ){

				posicao_cano_movimento_horizontal -= delta_time * 200;

				// evento de click
				if (Gdx.input.justTouched()) {
					velocidade_queda = -15;
				}

				// reniciando posição do cano verificando se saiu inteiramente da tela
				if (posicao_cano_movimento_horizontal < -largura_cano) {
					posicao_cano_movimento_horizontal = largura_tela;
					altura_entre_canos_randomica = numero_randomico.nextInt(800) - 200;
					marcou_ponto = false;
				}

				if(posicao_cano_movimento_horizontal < 120){
					if(!marcou_ponto){
						pontuacao++;
						marcou_ponto = true;
					}
				}
			}else{

				if ( Gdx.input.justTouched() ) {
					estatado_jogo = 0;
					pontuacao = 0;
					velocidade_queda = 0;
					posicao_inicial_vertical = altura_tela / 2;
					posicao_cano_movimento_horizontal = largura_tela;
				}

			}

		}
		// para exibir alguma textura
		batch.begin();

		// colocar textura na posição x,y
		batch.draw(fundo, 0,0, largura_tela, altura_tela);

		// movimento do cano
		movimentoY_cano_topo = altura_tela/2 + espaço_entre_canos/2 + altura_entre_canos_randomica;
		movimentoY_cano_baixo = altura_tela/2 - cano_baixo.getHeight() - espaço_entre_canos/2 + altura_entre_canos_randomica;
		batch.draw(cano_topo, posicao_cano_movimento_horizontal, movimentoY_cano_topo, (float)largura_cano, (float)altura_cano);
		batch.draw(cano_baixo, posicao_cano_movimento_horizontal, movimentoY_cano_baixo, (float)largura_cano, (float)altura_cano);

		// movimento passaro
		batch.draw(passaros[(int)variacao], 120, posicao_inicial_vertical, (float)largura_passaro, (float)altura_passaro);

		// potuação
		fonte.draw(batch, String.valueOf(pontuacao), largura_tela/2, altura_tela-100);

		// Game Over
		if(	estatado_jogo == 2 ) {
			batch.draw(game_over, largura_tela / 2 - (float)largura_game_over/2, altura_tela / 2, (float)largura_game_over, (float)altura_game_over);
			menssagem.draw(batch,"Toque para reiniciar!", (float)largura_tela/2 - 400, (float)altura_tela/2 - (float)altura_game_over/2);
		}

		batch.end();

		passaro_circulo.set(
				120 + (float)largura_passaro/2,
				posicao_inicial_vertical + (float)altura_passaro/2,
				(float)largura_passaro/2
		);
		retangulo_cano_topo.set(
				posicao_cano_movimento_horizontal,
				movimentoY_cano_topo,
				(float)largura_cano, (float)altura_cano
		);
		retangulo_cano_baixo.set(
				posicao_cano_movimento_horizontal,
				movimentoY_cano_baixo,
				(float)largura_cano, (float)altura_cano
		);

		// Desenha formas
		/*
		shape.begin(ShapeRenderer.ShapeType.Filled);

		shape.circle(passaro_circulo.x, passaro_circulo.y, passaro_circulo.radius);
		shape.rect(retangulo_cano_topo.x, retangulo_cano_topo.y, retangulo_cano_topo.width, retangulo_cano_topo.height);
		shape.rect(retangulo_cano_baixo.x, retangulo_cano_baixo.y, retangulo_cano_baixo.width, retangulo_cano_baixo.height);
		shape.setColor(Color.RED);

		shape.end();
		*/

		// Colisões
		if(Intersector.overlaps(passaro_circulo, retangulo_cano_topo) || Intersector.overlaps(passaro_circulo, retangulo_cano_baixo)
			|| posicao_inicial_vertical <= 0 || posicao_inicial_vertical >= altura_tela){
			estatado_jogo = 2;
		}

	}

}
