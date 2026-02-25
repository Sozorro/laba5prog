package manager;

import java.util.HashMap;
import com.*;

import exeptions.WrongParam;

public class ComParser {
    private HashMap<String, Command> commands = new HashMap<>();
    ComParser() {
        commands.put("AddCom", new AddCom());
        commands.put("ClearCom", new ClearCom());
        commands.put("ExecuteScriptCom", new ExecuteScriptCom());
        commands.put("ExitCom", new ExitCom());
        commands.put("HelpCom", new HelpCom());
        commands.put("HistoryCom", new HistoryCom());
        commands.put("InfoCom", new InfoCom());
        commands.put("RemoveCom", new RemoveCom());
        commands.put("SaveCom", new SaveCom());
        commands.put("ShowCom", new ShowCom());
        commands.put("UpdateCom", new UpdateCom());

    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void interpret(String name, String... args) {
        Command command = this.commands.get(name);
        if (command == null) {
            throw new WrongParam("Неверная команда, проверьте корректность ввода");
        }
        else {
            command.execute(args);
        }
    }
    
}
