package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {

    private String _path;
    private FileOutputStream _fos;

    public FileWriter(String path) {
        _path = path;
    }

    public void open() {
        if (_fos == null) {
            try {
                _fos = new FileOutputStream(new File(_path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String str) {
        try {
            _fos.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            _fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String path) {
        _path = path;
    }

}
