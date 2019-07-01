package com.missionbit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.missionbit.flappybird.FlappyBird;

public class GameOverState extends State {
    private static final int GAMEOVER_Y_OFFSET = 80;

    private Texture background;
    private Texture gameOver;
    private Texture playButton;

    public GameOverState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(
                false,
                FlappyBird.WIDTH / 2,
                FlappyBird.HEIGHT / 2);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
        gameOver = new Texture("gameover.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        super.render(sb);

        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(gameOver,
                cam.position.x - gameOver.getWidth() / 2,
                GAMEOVER_Y_OFFSET);
        sb.draw(playButton,
                cam.position.x - playButton.getWidth() / 2,
                cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        gameOver.dispose();
    }
}
