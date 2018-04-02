package de.thi.container.data;

import android.app.Application;

public class ContainerApplication extends Application{
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
