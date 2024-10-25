package use_case.login;

import entity.User;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginUserDataAccessInterface userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessObject, LoginOutputBoundary loginPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void execute(LoginInputData inputData) {
        User user = userDataAccessObject.get(inputData.getUsername());
        userDataAccessObject.setCurrentUser(user.getName()); // Add this line
        LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
        loginPresenter.prepareSuccessView(loginOutputData);
    }
}
