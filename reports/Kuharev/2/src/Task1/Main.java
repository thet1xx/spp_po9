public class Main {
    public static void main(String[] args) {
        String[] types = {"noun", "adjective", "verb", "preposition"};
        String formated_string = Const.CLEAR, output = Const.CLEAR;
        StringDynamicArray[] type_array_navp = new StringDynamicArray[types.length];
        IFile workWith_txt = new IFile();
        try{
            output = args[Const.first_element];
        } catch(Exception ex){
            System.out.println("Arguments are empty, using default output file");
            output = "output";
        }

        workWith_txt.ClearFile(output);

        for(int i = 0; i < types.length; ++i){
            type_array_navp[i] = workWith_txt.ReadStrings(types[i]);
        }
        for(int i = 0; i < Const.sentences_amount; ++i){
            formated_string = type_array_navp[Const.noun].getRandom() + ' '
                    + type_array_navp[Const.verb].getRandom() + ' ' + type_array_navp[Const.preposition].getRandom() + ' '
                    + type_array_navp[Const.adjective].getRandom() + ' ' + type_array_navp[Const.noun].getRandom() + ".\n";

            formated_string = Character.toUpperCase(formated_string.charAt(Const.first_element))
                    + formated_string.substring(Const.lower_case_start);
            workWith_txt.WriteString(formated_string, output);
            formated_string = Const.CLEAR;
        }
    }
}