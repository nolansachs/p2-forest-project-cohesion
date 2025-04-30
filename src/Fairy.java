import processing.core.PImage;

import java.util.List;

public class Fairy extends Entity{
    public static final String FAIRY_KEY = "fairy";
    public static final int FAIRY_ANIMATION_PERIOD_IDX = 0;
    public static final int FAIRY_ACTION_PERIOD_IDX = 1;
    public static final int FAIRY_NUM_PROPERTIES = 2;

    /**
     * Creates a new Fairy.
     * @param id The Fairy's id
     * @param position The Fairy's x,y location in the World.
     * @param actionPeriod The time (seconds) taken for each activity (turning a Stump into a Sapling).
     * @param animationPeriod The time (seconds) taken for each animation.
     * @param images Images to use for the Fairy.
     * @return a new Entity whose type is Fairy.
     */
    Fairy(String id, Point position, double actionPeriod, double animationPeriod, List<PImage> images) {
        super(EntityKind.FAIRY, id, position, images, 0, 0, actionPeriod, animationPeriod, 0, 0);
    }
}
