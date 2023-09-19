package chapater11.practise5.movefiles;

import chapater11.practise3.CopyFiles;

import java.io.*;

public class MoveFiles {
    public static void main(String[] args) {
        System.out.println("Please input will move source file or directory");
        InputStreamReader isr;
        BufferedReader br;
        try {
            {
                isr = new InputStreamReader(System.in);
                br = new BufferedReader(isr);

                String fileordir = br.readLine().trim();

                System.out.println("Please input will move destination directory");
                isr = new InputStreamReader(System.in);
                br = new BufferedReader(isr);
                String destination = br.readLine().trim();

                MoveFiles moveFiles = new MoveFiles();

                moveFiles.movefiledir(fileordir, destination);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    protected void movefiledir(String fileordir, String destination) throws FileNotFoundException, IOException {

        File fileordirectory = new File(fileordir);
        //it is a file.
        if (fileordirectory.isFile()) {
            movefile(fileordir, destination);
        } else  //this is a dir.
        {
            //find source dir last directory, then add the directory in destination directory.
            String truncateName = fileordir.substring(fileordir.lastIndexOf("/") + 1);
            File filedir = new File(destination + "/" + truncateName);
            if (!filedir.exists()) {
                filedir.mkdirs();
            }

            String files[] = fileordirectory.list();
            for (String file : files) {
                System.out.println(file);
                //recursive call the function.
                if (file == "." || file == "..") {
                    continue;
                }
                this.movefiledir(fileordir + "/" + file, destination + "/" + truncateName);
            }
            //delete the source dir.
            fileordirectory.delete();
        }
    }

    /**
     * standard method is file copy to dir.
     */
    protected boolean movefile(String origin, String destination) {
        File source = new File(origin);
        String line;
        {
            if (source.isFile()) {
                String truncateName = origin.substring(origin.lastIndexOf("/"));
                try {
                    {
                        FileWriter fw = new FileWriter(destination + truncateName);
                        FileReader fr = new FileReader(source);
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw);
                        while ((line = br.readLine()) != null) {
                            bw.write(line);
                        }
                        //remove the origin file.
                        source.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }
}

