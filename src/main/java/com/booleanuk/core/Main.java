package com.booleanuk.core;

import com.migzus.terminal.menus.Button;
import com.migzus.terminal.menus.Callable;
import com.migzus.terminal.menus.Menu;

public class Main {
    public static void main(String[] args) {
        BankManager _bm = new BankManager();
        Menu _mainMenu = new Menu("Login");

        _mainMenu.pushButton(new Button("As a Customer", new Callable(_bm, "accountOverview")));
        _mainMenu.pushButton(new Button("As a Bank Manager", new Callable(_bm, "bankManagement")));
        _mainMenu.pushButton(new Button("Quit", new Callable(_mainMenu, "unfocus")));

        _mainMenu.focus();
    }
}
