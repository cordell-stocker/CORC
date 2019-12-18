/*
Copyright 2019, Cordell Stocker (cordellstocker@gmail.com)
All rights reserved.

This file is part of CORC GinCore.

    CORC GinCore is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CORC GinCore is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CORC GinCore.  If not, see <https://www.gnu.org/licenses/>.
*/
package corc.javafxextend.standard;

import corc.javafxextend.structure.OptionPanel;

/**
 * A panel that serves no major function other than to pause
 * model code until "Continue" is clicked.
 */
public class ContinuePanel extends OptionPanel<String> {

    private static String[] options = new String[]{"Continue"};

    public ContinuePanel() {
        super("", ContinuePanel.options, DEFAULT_HEADER_STYLE, DEFAULT_BUTTON_STYLE);
    }

    public void getContinue() {
        super.getOptionClicked();
    }
}
