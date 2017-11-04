package mobi.mpk.chessandroid.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobi.mpk.chessandroid.net.WebSocketConnection;
import mobi.mpk.chessandroid.net.listener.client.ClientWebSocketListener;
import mobi.mpk.chessandroid.net.listener.client.DefaultClientWebSocketListener;
import mobi.mpk.chessandroid.presenter.lobby.in.LobbyPresenterIn;
import mobi.mpk.chessandroid.settings.Settings;

@Module
public class NetModule {

    @Provides
    @Singleton
    public WebSocketConnection provideWebSocketConnection(Settings settings) {
        return new WebSocketConnection(settings);
    }

    @Provides
    @Singleton
    public ClientWebSocketListener provideClientWebSocketListener(WebSocketConnection connection, Settings settings) {
        return new DefaultClientWebSocketListener(connection, settings);
    }

}
