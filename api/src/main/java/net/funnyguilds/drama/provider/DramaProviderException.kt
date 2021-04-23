package net.funnyguilds.drama.provider;

public class DramaProviderException extends RuntimeException {

    public DramaProviderException() {
    }

    public DramaProviderException(String message) {
        super(message);
    }

    public DramaProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DramaProviderException(Throwable cause) {
        super(cause);
    }

    public DramaProviderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
