package mobi.mpk.chessandroid.interactor;


import mobi.mpk.chessandroid.interactor.stategame.StateGame;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.presenter.Presenter;
import mobi.mpk.chessandroid.type.ResultType;

public class NetInteractorOut implements InteractorOut {

    private NetListenerEvent listener;

    private PresenterOut presenter;

    private StateGame stateGame;
    private User user;

    public NetInteractorOut(NetListenerEvent listener,
                            PresenterOut presenter,
                            StateGame stateGame,
                            User user) {

        this.listener = listener;

        this.presenter = presenter;

        this.stateGame = stateGame;
        this.user = user;

    }

    @Override
    public void makeMove(String move) {

        if (stateGame.checkExistGame()) {

            ResultType resultType = stateGame.getGame().doStroke(user, move);

            if(resultType == ResultType.SUCCESS || resultType == ResultType.ATTACK) {

                listener.sendMove(user.getName(), move);
                presenter.makeMove(move);

            }

        }

    }

}
