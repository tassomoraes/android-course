package com.tlom.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

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
	private float largura_tela;
	private float altura_tela;
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

	private float largura_passaro;
	private float altura_passaro;
	private float largura_cano;
	private float altura_cano;
	private float largura_game_over;
	private float altura_game_over;

	// Câmera
	private OrthographicCamera camera;
	private Viewport viewport;
	private final float VIRTUAL_WIDTH = 768;	// resolução fixa
	private final float VIRTUAL_HEIGHT = 1024;	// outra opção é 600x800

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
		fonte.getData().setScale(5);

		menssagem = new BitmapFont();
		menssagem.setColor(Color.WHITE);
		menssagem.getData().setScale(2);

		batch = new SpriteBatch();

		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");
		cano_baixo = new Texture("cano_baixo.png");
		cano_topo = new Texture("cano_topo.png");

		game_over = new Texture("game_over.png");

		/**********************************************************
		 * Configuração da Câmera
		* */
		camera = new OrthographicCamera();
		//posicionando a cêmera
		camera.position.set(VIRTUAL_WIDTH/2, VIRTUAL_HEIGHT/2, 0);
		viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		//viewport = new StretchViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);	// largura, altura, e cêmera

		// getWidth recupera a largura da tela e getHight peda a altura
		largura_tela = VIRTUAL_WIDTH;
		altura_tela = VIRTUAL_HEIGHT;

		posicao_inicial_vertical = altura_tela/2;

		posicao_cano_movimento_horizontal = largura_tela;
		espaço_entre_canos = 210;

		// canos
		largura_cano = cano_topo.getWidth();
		altura_cano = cano_topo.getHeight();
		// passaro
		largura_passaro = passaros[(int)variacao].getWidth();
		altura_passaro = passaros[(int)variacao].getHeight();
		// game over
		largura_game_over = game_over.getWidth();
		altura_game_over = game_over.getHeight();

	}

	// Para as animações
	@Override
	public void render () {

		camera.update();

		// Limpar os frames anteriores para que o jogo utilize menos memória
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		delta_time = Gdx.graphics.getDeltaTime();    // pega o tempo entre um render e outra
		variacao += delta_time * 10; // para o passaro se mover na tela
		if (variacao > 2) variacao = 0; // o passaro só possue 3 posições 0, 1 e 2

		if ( estatado_jogo == 0 ){
			if (Gdx.input.justTouched()){
				estatado_jogo = 1;
			}
		}else {

			velocidade_queda++;
			if (posicao_inicial_vertical > 0 || velocidade_queda < 0)
				posicao_inicial_vertical -= velocidade_queda;

			if ( estatado_jogo == 1 ){

				posicao_cano_movimento_horizontal -= delta_time * 200+(pontuacao/10);	// velocidade dos canos almenta de acordo com a pontuação

				// evento de click
				if (Gdx.input.justTouched()) {
					velocidade_queda = -15;
				}

				// reniciando posição do cano verificando se saiu inteiramente da tela
				if (posicao_cano_movimento_horizontal < -largura_cano) {
					posicao_cano_movimento_horizontal = largura_tela;
					altura_entre_canos_randomica = numero_randomico.nextInt(400) - 200;
					marcou_ponto = false;
				}

				if(posicao_cano_movimento_horizontal < 120){
					if(!marcou_ponto){
						pontuacao++;
						marcou_ponto = true;
					}
				}
			}else{	//Game Over
				//Zera os valores padrões
				if ( Gdx.input.justTouched() ) {
					estatado_jogo = 0;
					pontuacao = 0;
					velocidade_queda = 0;
					posicao_inicial_vertical = altura_tela / 2;
					posicao_cano_movimento_horizontal = largura_tela;
					marcou_ponto = false;
				}

			}

		}

		// Configurar dados de projeção da câmera
		batch.setProjectionMatrix(camera.combined);		// recuperando dados de projeção


		// para exibir alguma textura
		batch.begin();

		// colocar textura na posição x,y
		batch.draw(fundo, 0,0, largura_tela, altura_tela);
		// movimento do cano
		movimentoY_cano_topo = altura_tela/2 + espaço_entre_canos/2 + altura_entre_canos_randomica;
		movimentoY_cano_baixo = altura_tela/2 - cano_baixo.getHeight() - espaço_entre_canos/2 + altura_entre_canos_randomica;
		batch.draw(cano_topo, posicao_cano_movimento_horizontal, movimentoY_cano_topo);
		batch.draw(cano_baixo, posicao_cano_movimento_horizontal, movimentoY_cano_baixo);
		// movimento passaro
		batch.draw(passaros[(int)variacao], 120, posicao_inicial_vertical);
		// potuação
		fonte.draw(batch, String.valueOf(pontuacao), largura_tela/2, altura_tela-50);

		// Game Over
		if(	estatado_jogo == 2 ) {
			menssagem.draw(batch,"Toque para reiniciar!", largura_tela/2 - 130, altura_tela/2 - altura_game_over/2);
			batch.draw(game_over, largura_tela / 2 - largura_game_over/2, altura_tela / 2	);
		}

		batch.end();

		passaro_circulo.set(
				120 + largura_passaro/2,
				posicao_inicial_vertical + altura_passaro/2,
				largura_passaro/2
		);
		retangulo_cano_topo.set(
				posicao_cano_movimento_horizontal,
				movimentoY_cano_topo,
				(float)largura_cano, (float)altura_cano
		);
		retangulo_cano_baixo.set(
				posicao_cano_movimento_horizontal,
				movimentoY_cano_baixo,
				largura_cano, altura_cano
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

	// método chamado sempre que a largura do dispositivo é alterada e no primeiro carregamento
	@Override
	public void resize(int width, int height) {
		viewport.update(width,height);
	}
}
