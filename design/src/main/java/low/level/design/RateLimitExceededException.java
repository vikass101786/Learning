package low.level.design;

public class RateLimitExceededException extends IllegalStateException {
    public RateLimitExceededException() {
        super("Rate limit exceeded");
    }
}