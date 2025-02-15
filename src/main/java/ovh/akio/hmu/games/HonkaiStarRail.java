package ovh.akio.hmu.games;

import ovh.akio.hmu.Utils;
import ovh.akio.hmu.entities.PckAudioFile;
import ovh.akio.hmu.entities.UpdatePackage;
import ovh.akio.hmu.exceptions.InvalidGameDirectoryException;

import java.io.File;
import java.util.List;

public class HonkaiStarRail implements HoyoverseGame {

    private final File basePath;

    public HonkaiStarRail(File basePath) {

        this.basePath = basePath;
        File gameDirectory = this.getGameDirectory();

        File gameExecutable = new File(gameDirectory, "StarRail.exe");

        if (!gameExecutable.exists()) {
            throw new InvalidGameDirectoryException("The path provided does not point to a valid game directory.");
        }
    }

    @Override
    public String getName() {

        return "Honkai: Star Rail";
    }

    @Override
    public File getGameDirectory() {

        return new File(this.basePath, "Games");
    }

    @Override
    public File getAudioDirectory() {

        return new File(this.getGameDirectory(), "StarRail_Data\\StreamingAssets\\Audio\\AudioPackage\\Windows");
    }

    @Override
    public UpdatePackage getUpdatePackage() {

        return null;
    }

    @Override
    public List<PckAudioFile> getAudioFiles() {

        return Utils.scanPck(this.getAudioDirectory());
    }
}
