package mobi.mpk.chessandroid.presenter.game.out;


import mobi.mpk.chessandroid.interactor.in.InteractorIn;
import mobi.mpk.chessandroid.repository.in.RepositoryIn;
import mobi.mpk.chessandroid.type.ResultType;

class NetGamePresenterOut implements GamePresenterOut {

    private RepositoryIn repository;
    private InteractorIn interactor;

    public NetGamePresenterOut(RepositoryIn repository, InteractorIn interactor) {

        this.repository = repository;
        this.interactor = interactor;

    }

    @Override
    public void makeMove(String move) {

        ResultType resultType = interactor.makeMove("Anonymous", move);

        if(resultType == ResultType.SUCCESS || resultType == ResultType.ATTACK) {

            repository.sendMove(move);

        }

    }

    @Override
    public void stopGame() {

        interactor.stopGame();
        repository.stopGame();

    }

}
