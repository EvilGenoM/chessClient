package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.interactor.in.DefaultInteractorIn;
import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.interactor.out.DefaultInteractorOut;
import mobi.mpk.chessandroid.interactor.out.InteractorOut;
import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.net.listener.client.ClientWebSocketListener;
import mobi.mpk.chessandroid.observer.model.GameData;
import mobi.mpk.chessandroid.presenter.game.in.DefaultGamePresenterIn;
import mobi.mpk.chessandroid.presenter.game.in.GamePresenterIn;
import mobi.mpk.chessandroid.presenter.game.out.GamePresenterOut;
import mobi.mpk.chessandroid.presenter.game.out.LocalGamePresenterOut;
import mobi.mpk.chessandroid.presenter.lobby.in.DefaultLobbyPresenterIn;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;
import mobi.mpk.chessandroid.presenter.lobby.out.LobbyPresenterOut;
import mobi.mpk.chessandroid.presenter.lobby.out.LocalLobbyPresenterOut;
import mobi.mpk.chessandroid.repository.in.NetRepositoryIn;
import mobi.mpk.chessandroid.repository.in.RepositoryIn;
import mobi.mpk.chessandroid.repository.out.NetRepositoryOut;
import mobi.mpk.chessandroid.repository.out.RepositoryOut;

@Module
public class CommunicationModule {

    @Provides
    @Singleton
    public LobbyPresenterIn provideLobbyPresenterIn() {
        return new DefaultLobbyPresenterIn();
    }

    @Provides
    @Singleton
    public GamePresenterIn provideGamePresenterIn() {
        return new DefaultGamePresenterIn();
    }

    @Provides
    @Singleton
    public InteractorIn provideInteractorIn(StateGame stateGame, GameData gameData) {
        return new DefaultInteractorIn(stateGame, gameData);
    }

    @Provides
    @Singleton
    public InteractorOut provideInteractorOut(GamePresenterIn gamePresenterIn, StateGame stateGame) {
        return new DefaultInteractorOut(gamePresenterIn, stateGame);
    }

    @Provides
    @Singleton
    public RepositoryIn provideRepositoryIn(ClientWebSocketListener listener) {
        return new NetRepositoryIn(listener);
    }

    @Provides
    @Singleton
    public RepositoryOut provideRepositoryOut(InteractorIn interactorIn, LobbyPresenterIn presenterIn) {
        return new NetRepositoryOut(interactorIn, presenterIn);
    }


    @Provides
    @Singleton
    public LobbyPresenterOut provideLobbyPresenterOut(RepositoryIn repositoryIn, LobbyPresenterIn presenterIn, InteractorIn interactorIn) {
        return new LocalLobbyPresenterOut(presenterIn, interactorIn);
    }

    @Provides
    @Singleton
    public GamePresenterOut provideGamePresenterOut(RepositoryIn repositoryIn, InteractorIn interactorIn, GamePresenterIn presenterIn) {

        return new LocalGamePresenterOut(interactorIn, presenterIn);

    }

}
