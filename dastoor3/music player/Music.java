public class Music {
    private String fileName;
    private String producerName;
    private int publishYear;
    private boolean isFavorite;

    /**
     * creates a new music by inputs and sets isFavorite as false
     * @param fileName the name of the music
     * @param producerName the music producer's name
     * @param publishYear the year music published
     */

    public Music(String fileName, String producerName, int  publishYear) {
        this.fileName = fileName;
        this.producerName = producerName;
        this.publishYear = publishYear;
        this.isFavorite = false;
    }

    /**
     * creates a new music by inputs
     *@param fileName the name of the music
     * @param producerName the music producer's name
     * @param publishYear the year music published
     * @param isFavorite is true if the music is the users favorite music , false if not
     */
    public Music (String fileName, String producerName, int  publishYear , boolean isFavorite){
        this.fileName = fileName;
        this.producerName = producerName;
        this.publishYear = publishYear;
        this.isFavorite = isFavorite;
    }

    /**
     *
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName sets the fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return music producer's name
     */
    public String getProducerName() {
        return producerName;
    }

    /**
     * sets the music producer's name
     * @param producerName
     */
    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    /**
     *
     * @return the publish year
     */
    public int  getPublishYear() {
        return publishYear;
    }

    /**
     * sets the music publish year
     * @param publishYear
     */
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * sets isFavorite
     * @param isFavorite
     */
    public void setIsFavorite(boolean isFavorite){
        this.isFavorite = isFavorite;
    }

    /**
     *
     * @return isFavorite
     */


    public boolean getIsFavorite(){
        return this.isFavorite;
    }
}
