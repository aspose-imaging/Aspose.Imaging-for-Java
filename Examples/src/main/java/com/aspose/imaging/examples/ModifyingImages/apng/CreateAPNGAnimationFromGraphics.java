package com.aspose.imaging.examples.ModifyingImages.apng;

import com.aspose.imaging.Color;
import com.aspose.imaging.Image;
import com.aspose.imaging.Pen;
import com.aspose.imaging.PointF;
import com.aspose.imaging.brushes.SolidBrush;
import com.aspose.imaging.examples.Logger;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.apng.ApngFrame;
import com.aspose.imaging.fileformats.apng.ApngImage;
import com.aspose.imaging.fileformats.png.PngColorType;
import com.aspose.imaging.imageoptions.ApngOptions;
import com.aspose.imaging.sources.FileCreateSource;

import java.util.ArrayList;
import java.util.Collection;

public class CreateAPNGAnimationFromGraphics
{
    public static void main(String... args)
    {
        Logger.startExample("CreateAPNGAnimationFromGraphics");

        // preparing the animation scene
        final int SceneWidth = 400;
        final int SceneHeigth = 400;
        // Act duration, in milliseconds
        final long ActDuration = 1000;
        // Total duration, in milliseconds
        final long TotalDuration = 4000;
        // Frame duration, in milliseconds
        final long FrameDuration = 50;
        Scene scene = new Scene();
        final Ellipse[] ellipse = { new Ellipse() };
        ellipse[0].setFillColor(Color.fromArgb(128, 128, 128));
        ellipse[0].setCenterPoint(new PointF(SceneWidth / 2f, SceneHeigth / 2f));
        ellipse[0].setRadiusX(80);
        ellipse[0].setRadiusY(80);
        scene.addObject(ellipse[0]);
        final Line[] line = { new Line() };
        line[0].setColor(Color.getBlue());
        line[0].setLineWidth(10);
        line[0].setStartPoint(new PointF(30, 30));
        line[0].setEndPoint(new PointF(SceneWidth - 30, 30));
        scene.addObject(line[0]);
        IAnimation lineAnimation1 = new LinearAnimation(progress -> {
            line[0].setStartPoint(new PointF(30 + (progress * (SceneWidth - 60)), 30 + (progress * (SceneHeigth - 60))));
            line[0].setColor(Color.fromArgb((int)((progress * 255)), 0, 255 - (int)((progress * 255))));
        });
        lineAnimation1.setDuration(ActDuration);
        IAnimation lineAnimation2 = new LinearAnimation(progress -> {
            line[0].setEndPoint(new PointF(SceneWidth - 30 - (progress * (SceneWidth - 60)), 30 + (progress * (SceneHeigth - 60))));
            line[0].setColor(Color.fromArgb(255, (int)((progress * 255)), 0));
        });
        lineAnimation2.setDuration(ActDuration);
        IAnimation lineAnimation3 = new LinearAnimation(progress -> {
            line[0].setStartPoint(new PointF(SceneWidth - 30 - (progress * (SceneWidth - 60)), SceneHeigth - 30 - (progress * (SceneHeigth - 60))));
            line[0].setColor(Color.fromArgb(255 - (int)((progress * 255)), 255, 0));
        });
        lineAnimation3.setDuration(ActDuration);
        IAnimation lineAnimation4 = new LinearAnimation(progress -> {
            line[0].setEndPoint(new PointF(30 + (progress * (SceneWidth - 60)), SceneHeigth - 30 - (progress * (SceneHeigth - 60))));
            line[0].setColor(Color.fromArgb(0, 255 - (int)((progress * 255)), (int)((progress * 255))));
        });
        lineAnimation4.setDuration(ActDuration);
        SequentialAnimation fullLineAnimation = new SequentialAnimation();
        fullLineAnimation.add(lineAnimation1);
        fullLineAnimation.add(lineAnimation2);
        fullLineAnimation.add(lineAnimation3);
        fullLineAnimation.add(lineAnimation4);
        IAnimation ellipseAnimation1 = new LinearAnimation(progress -> {
            ellipse[0].setRadiusX(ellipse[0].getRadiusX() + (progress * 10));
            ellipse[0].setRadiusY(ellipse[0].getRadiusY() + (progress * 10));
            int compValue = (int)((128 + (progress * 112)));
            ellipse[0].setFillColor(Color.fromArgb(compValue, compValue, compValue));
        });
        ellipseAnimation1.setDuration(ActDuration);
        IAnimation ellipseAnimation2 = new Delay();
        ellipseAnimation2.setDuration(ActDuration);
        IAnimation ellipseAnimation3 = new LinearAnimation(progress -> {
            ellipse[0].setRadiusX(ellipse[0].getRadiusX() - (progress * 10));
            int compValue = (int)((240 - (progress * 224)));
            ellipse[0].setFillColor(Color.fromArgb(compValue, compValue, compValue));
        });
        ellipseAnimation3.setDuration(ActDuration);
        IAnimation ellipseAnimation4 = new LinearAnimation(progress -> {
            ellipse[0].setRadiusY(ellipse[0].getRadiusY() - (progress * 10));
            int compValue = (int)((16 + (progress * 112)));
            ellipse[0].setFillColor(Color.fromArgb(compValue, compValue, compValue));
        });
        ellipseAnimation4.setDuration(ActDuration);
        SequentialAnimation fullEllipseAnimation = new SequentialAnimation();
        fullEllipseAnimation.add(ellipseAnimation1);
        fullEllipseAnimation.add(ellipseAnimation2);
        fullEllipseAnimation.add(ellipseAnimation3);
        fullEllipseAnimation.add(ellipseAnimation4);
        ParallelAnimation tmp0 = new ParallelAnimation();
        tmp0.add(fullLineAnimation);
        tmp0.add(fullEllipseAnimation);
        scene.setAnimation(tmp0);
        // playing the scene on the newly created ApngImage
        try (ApngOptions createOptions = new ApngOptions())
        {
            createOptions.setSource(new FileCreateSource(Utils.getOutDir() + "vector_animation.png", false));
            createOptions.setColorType(PngColorType.TruecolorWithAlpha);
            try (ApngImage image = (ApngImage) Image.create(createOptions, SceneWidth, SceneHeigth))
            {
                image.setDefaultFrameTime(FrameDuration);
                scene.play(image, TotalDuration);
                image.save();
            }
        }

        Logger.endExample();
    }
}

/////////////////////////// Scene.java /////////////////////////////

/**
 * <p>
 * The graphics scene
 * </p>
 */
class Scene
{

    /**
     * <p>
     * The graphics objects
     * </p>
     */
    private final java.util.List<IGraphicsObject> graphicsObjects = new ArrayList<>();

    /**
     * <p>
     * Gets the animation.
     * </p>
     */
    public final IAnimation getAnimation()
    {
        return animation;
    }

    /**
     * <p>
     * Sets the animation.
     * </p>
     */
    public final void setAnimation(IAnimation value)
    {
        animation = value;
    }

    private IAnimation animation;

    /**
     * <p>
     * Adds the graphics object.
     * </p>
     *
     * @param graphicsObject The graphics object.
     */
    public final void addObject(IGraphicsObject graphicsObject)
    {
        this.graphicsObjects.add(graphicsObject);
    }

    /**
     * <p>
     * Plays scene on the specified animation image.
     * </p>
     *
     * @param animationImage The animation image.
     * @param totalDuration  The total duration.
     */
    public final void play(ApngImage animationImage, long totalDuration)
    {
        /*UInt32*/
        long frameDuration = animationImage.getDefaultFrameTime();
        /*UInt32*/
        long numFrames = (totalDuration / frameDuration);
        /*UInt32*/
        long totalElapsed = 0;
        for (/*UInt32*/long frameIndex = 0; frameIndex < numFrames; frameIndex++)
        {
            if (this.getAnimation() != null)
            {
                this.getAnimation().update(totalElapsed);
            }
            ApngFrame frame = animationImage.getPageCount() == 0 || frameIndex > 0 ? animationImage.addFrame() : (ApngFrame) animationImage.getPages()[0];
            com.aspose.imaging.Graphics graphics = new com.aspose.imaging.Graphics(frame);
            //foreach to while statements conversion
            for (IGraphicsObject graphicsObject : graphicsObjects)
            {
                graphicsObject.render(graphics);
            }
            totalElapsed = (totalElapsed + frameDuration);
        }
    }
}

/////////////////////////// IGraphicsObject.java /////////////////////////////
/**
 * <p>
 * The graphics object
 * </p>
 */
interface IGraphicsObject
{

    /**
     * <p>
     * Renders this instance using specified graphics.
     * </p>
     *
     * @param graphics The graphics.
     */
    void render(com.aspose.imaging.Graphics graphics);
}


/////////////////////////// Line.java /////////////////////////////

/**
 * <p>
 * The line
 * </p>
 */
class Line implements IGraphicsObject
{
    /**
     * <p>
     * Gets the start point.
     * </p>
     *
     * @return the start point.
     */
    public final PointF getStartPoint()
    {
        return startPoint.Clone();
    }

    /**
     * <p>
     * Sets the start point.
     * </p>
     *
     */
    public final void setStartPoint(PointF value)
    {
        startPoint = value.Clone();
    }

    private PointF startPoint = new PointF();

    /**
     * <p>
     * Gets the end point.
     * </p>
     *
     */
    public final PointF getEndPoint()
    {
        return endPoint.Clone();
    }

    /**
     * <p>
     * Sets the end point.
     * </p>
     *
     */
    public final void setEndPoint(PointF value)
    {
        endPoint = value.Clone();
    }

    private PointF endPoint = new PointF();

    /**
     * <p>
     * Gets the width of the line.
     * </p>
     *
     */
    public final float getLineWidth()
    {
        return lineWidth;
    }

    /**
     * <p>
     * Sets the width of the line.
     * </p>
     *
     * @param value the width of the line.
     */
    public final void setLineWidth(float value)
    {
        lineWidth = value;
    }

    private float lineWidth;

    /**
     * <p>
     * Gets the color.
     * </p>
     *
     * @return the color.
     */
    public final Color getColor()
    {
        return color;
    }

    /**
     * <p>
     * Sets the color.
     * </p>
     *
     * @param value the color.
     */
    public final void setColor(Color value)
    {
        color = value.Clone();
    }

    private Color color = new Color();

    /**
     * <p>
     * Renders this instance using specified graphics.
     * </p>
     *
     * @param graphics The graphics.
     */
    public final void render(com.aspose.imaging.Graphics graphics)
    {
        graphics.drawLine(new Pen(color, lineWidth), startPoint, endPoint);
    }
}

/////////////////////////// Ellipse.java /////////////////////////////

/**
 * <p>
 * The ellipse
 * </p>
 */
class Ellipse implements IGraphicsObject
{

    /**
     * <p>
     * Gets the color of the fill.
     * </p>
     *
     * @return the color of the fill.
     */
    public final Color getFillColor()
    {
        return fillColor.Clone();
    }

    /**
     * <p>
     * Sets the color of the fill.
     * </p>
     *
     * @param value the color of the fill.
     */
    public final void setFillColor(Color value)
    {
        fillColor = value.Clone();
    }

    private Color fillColor = new Color();

    /**
     * <p>
     * Gets the center point.
     * </p>
     *
     * @return the center point.
     */
    public final PointF getCenterPoint()
    {
        return centerPoint.Clone();
    }

    /**
     * <p>
     * Sets the center point.
     * </p>
     *
     * @param value the center point.
     */
    public final void setCenterPoint(PointF value)
    {
        centerPoint = value.Clone();
    }

    private PointF centerPoint = new PointF();

    /**
     * <p>
     * Gets the radius x.
     * </p>
     *
     * @return the radius x.
     */
    public final float getRadiusX()
    {
        return radiusX;
    }

    /**
     * <p>
     * Sets the radius x.
     * </p>
     *
     * @param value the radius x.
     */
    public final void setRadiusX(float value)
    {
        radiusX = value;
    }

    private float radiusX;

    /**
     * <p>
     * Gets the radius y.
     * </p>
     *
     * @return the radius y.
     */
    public final float getRadiusY()
    {
        return radiusY;
    }

    /**
     * <p>
     * Sets the radius y.
     * </p>
     *
     * @param value the radius y.
     */
    public final void setRadiusY(float value)
    {
        radiusY = value;
    }

    private float radiusY;

    /**
     * <p>
     * Renders this instance using specified graphics.
     * </p>
     *
     * @param graphics The graphics.
     */
    @Override
    public final void render(com.aspose.imaging.Graphics graphics)
    {
        graphics.fillEllipse(new SolidBrush(fillColor), centerPoint.getX() - radiusX
                , centerPoint.getY() - radiusY, radiusX * 2, radiusY * 2);
    }
}

/////////////////////////// IAnimation.java /////////////////////////////
/**
 * <p>
 * The animation
 * </p>
 */
interface IAnimation
{

    /**
     * <p>
     * Gets the duration.
     * </p>
     *
     * @return the duration.
     */
    long getDuration();

    /**
     * <p>
     * Sets the duration.
     * </p>
     *
     * @param value the duration.
     */
    void setDuration(long value);

    /**
     * <p>
     * Updates the animation progress.
     * </p>
     *
     * @param elapsed The elapsed time, in milliseconds.
     */
    void update(long elapsed);
}


/////////////////////////// LinearAnimation.java /////////////////////////////
/**
 * <p>
 * The linear animation
 * </p>
 */
class LinearAnimation implements IAnimation
{

    /**
     * <p>
     * The progress handler
     * </p>
     */
    private final AnimationProgressHandler progressHandler;

    /**
     * <p>
     * Animation progress handler delegate
     * </p>
     */
    public interface AnimationProgressHandler
    {
        /**
         * <p>
         * Animation progress handler delegate
         * </p>
         *
         * @param progress The progress, in [0;1] range.
         */
        void invoke(float progress);
    }

    /**
     * <p>
     * Initializes a new instance of the {@link LinearAnimation} class.
     * </p>
     *
     * @param progressHandler The progress handler.
     * @throws NullPointerException progressHandler is null.
     */
    public LinearAnimation(AnimationProgressHandler progressHandler)
    {
        if (progressHandler == null)
        {
            throw new NullPointerException("progressHandler");
        }
        this.progressHandler = progressHandler;
    }

    /**
     * <p>
     * Gets the duration.
     * </p>
     *
     * @return the duration.
     */
    @Override
    public final long getDuration()
    {
        return duration;
    }

    /**
     * <p>
     * Sets the duration.
     * </p>
     *
     * @param value the duration.
     */
    @Override
    public final void setDuration(long value)
    {
        duration = value;
    }

    private long duration;

    /**
     * <p>
     * Updates the animation progress.
     * </p>
     *
     * @param elapsed The elapsed time, in milliseconds.
     */
    @Override
    public final void update(long elapsed)
    {
        if (elapsed <= duration)
        {
            this.progressHandler.invoke((float) elapsed / duration);
        }
    }
}

/////////////////////////// Delay.java /////////////////////////////
/**
 * <p>
 * The simple delay between other animations
 * </p>
 */
class Delay implements IAnimation
{

    /**
     * <p>
     * Gets the duration.
     * </p>
     *
     * @return the duration.
     */
    @Override
    public final long getDuration()
    {
        return duration;
    }

    /**
     * <p>
     * Sets the duration.
     * </p>
     *
     * @param value the duration.
     */
    @Override
    public final void setDuration(long value)
    {
        duration = value;
    }

    private long duration;

    /**
     * <p>
     * Updates the animation progress.
     * </p>
     *
     * @param elapsed The elapsed time, in milliseconds.
     */
    @Override
    public final void update(long elapsed)
    {
        // Do nothing
    }
}

/**
 * <p>
 * The parallel animation processor
 * </p>
 */
class ParallelAnimation extends ArrayList<IAnimation> implements IAnimation
{

    /**
     * <p>
     * Initializes a new instance of the {@link ParallelAnimation} class.
     * </p>
     */
    public ParallelAnimation()
    {
        // Do nothing

    }

    /**
     * <p>
     * Initializes a new instance of the {@link ParallelAnimation} class.
     * </p>
     *
     * @param animations The animations.
     */
    public ParallelAnimation(Collection<IAnimation> animations)
    {
        super(animations);
    }

    /**
     * <p>
     * Gets the duration.
     * </p>
     *
     * @return the duration.
     */
    @Override
    public final long getDuration()
    {
        long maxDuration = 0;
        for (IAnimation animation : this)
        {
            if (maxDuration < animation.getDuration())
            {
                maxDuration = animation.getDuration();
            }
        }
        return maxDuration;
    }

    /**
     * <p>
     * Sets the duration.
     * </p>
     *
     * @param value the duration.
     */
    @Override
    public final void setDuration(long value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Updates the animation progress.
     * </p>
     *
     * @param elapsed The elapsed time, in milliseconds.
     */
    @Override
    public final void update(long elapsed)
    {
        for (IAnimation animation : this)
        {
            animation.update(elapsed);
        }
    }
}

/**
 * <p>
 * The sequential animation processor
 * </p>
 */
class SequentialAnimation extends ArrayList<IAnimation> implements IAnimation
{

    /**
     * <p>
     * Initializes a new instance of the {@link SequentialAnimation} class.
     * </p>
     */
    public SequentialAnimation()
    {
        // Do nothing

    }

    /**
     * <p>
     * Initializes a new instance of the {@link SequentialAnimation} class.
     * </p>
     *
     * @param animations The animations.
     */
    public SequentialAnimation(Collection<IAnimation> animations)
    {
        super(animations);
    }

    /**
     * <p>
     * Gets the duration.
     * </p>
     *
     * @return the duration.
     */
    @Override
    public final long getDuration()
    {
        /*UInt32*/
        long summDuration = 0;
        for (IAnimation animation : this)
        {
            summDuration = summDuration + animation.getDuration();
        }
        return summDuration;
    }

    /**
     * <p>
     * Sets the duration.
     * </p>
     *
     * @param value the duration.
     */
    @Override
    public final void setDuration(long value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * <p>
     * Updates the animation progress.
     * </p>
     *
     * @param elapsed The elapsed time, in milliseconds.
     */
    @Override
    public final void update(long elapsed)
    {
        long totalDuration = 0;
        for (IAnimation animation : this)
        {
            if (totalDuration > elapsed)
            {
                break;
            }
            animation.update((elapsed - totalDuration));
            totalDuration = totalDuration + animation.getDuration();
        }
    }
}
