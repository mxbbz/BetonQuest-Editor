/**
 * BetonQuest Editor - advanced quest creating tool for BetonQuest
 * Copyright (C) 2016  Jakub "Co0sh" Sapalski
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.betoncraft.betonquest.editor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import pl.betoncraft.betonquest.editor.data.ConditionWrapper;

/**
 * Controls list cell which displays a wrapped condition.
 *
 * @author Jakub Sapalski
 */
public class ConditionListCellController {
	
	private ConditionWrapper condition;
	@FXML private Text text;
	@FXML private CheckBox box;
	
	@FXML public void tick() {
		try {
			condition.setNegated(box.isSelected());
		} catch (Exception e) {
			ExceptionController.display(e);
		}
	}
	
	public void invert() {
		box.setSelected(!box.isSelected());
		tick();
	}

	/**
	 * Displays this condition in the cell.
	 * 
	 * @param item ConditionWrapper containing the Condition
	 */
	public void setCondition(ConditionWrapper item) {
		condition = item;
		text.setText(condition.toString());
		box.setSelected(condition.getNegated());
	}
	
	/**
	 * Clears the displayed condition.
	 */
	public void clear() {
		condition = null;
		text.setText("");
		box.setSelected(false);
	}

	/**
	 * @return the condition currently displayed in the cell
	 */
	public ConditionWrapper getCondition() {
		return condition;
	}

}
