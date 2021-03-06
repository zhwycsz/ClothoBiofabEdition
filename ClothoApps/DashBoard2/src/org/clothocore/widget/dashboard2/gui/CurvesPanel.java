package org.clothocore.widget.dashboard2.gui;

/*
 * Copyright (c) 2007, Romain Guy
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following
 *     disclaimer in the documentation and/or other materials provided
 *     with the distribution.
 *   * Neither the name of the TimingFramework project nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

/**
 * This is the moving curves at the base of the jframe
 * @author jcanderson
 */
public class CurvesPanel extends JPanel {
    protected RenderingHints hints;
    protected int counter = 0;

    //JCA these are the transparency ranges for the moving curves at bottom
    protected Color start = new Color(255, 246, 225, 30);
    protected Color end = new Color(255, 255, 255, 10);
    
    public CurvesPanel() {
        this(new BorderLayout());
    }
    
    public CurvesPanel(LayoutManager manager) {
        super(manager);
        hints = createRenderingHints();
    }
    
    protected RenderingHints createRenderingHints() {
        RenderingHints rhHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rhHints.put(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        rhHints.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        return rhHints;
    }
    
    public void animate() {
        counter++;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        RenderingHints oldHints = g2.getRenderingHints();
        g2.setRenderingHints(hints);
        
        float width = getWidth();
        float height = getHeight();
        
        g2.translate(0, -30);

        //Put in the upper curves
        drawCurve(g2,
                -100.0f, -10.0f,                //y1  left vertical center, how much it sways up and down on left side
                40.0f, -10.0f,                //y2  right vertical center, how much it sways up and down on right side

                width / 2.0f - 40.0f, 10.0f,  //cx1 no idea what these do
                0.0f, -5.0f,                  //cy1 increasing first number makes it wavier, deflection of left-most hump

                width / 2.0f + 40, 10.0f,      //cx2
                0.0f, 5.0f,                   //cy2 , same as cy1, but corresponds to right hump

                90.0f, 20.0f, true);          //thickness, speed, invert  big is big, big is slow, boolean can flip whole thing

        g2.translate(0, height/3);

        //Put in middle curve
        drawCurve(g2,
                90.0f, -10.0f,                //y1  left vertical center, how much it sways up and down on left side
                -80.0f, -10.0f,                //y2  right vertical center, how much it sways up and down on right side

                width / 2.0f - 40.0f, 10.0f,  //cx1 no idea what these do
                0.0f, -5.0f,                  //cy1 increasing first number makes it wavier, deflection of left-most hump

                width / 2.0f + 40, 10.0f,      //cx2
                0.0f, 5.0f,                   //cy2 , same as cy1, but corresponds to right hump

                290.0f, 10.0f, false);          //thickness, speed, invert  big is big, big is slow, boolean can flip whole thing

        g2.translate(0, height*2/3-40);

        //Put in lowermost curve
        drawCurve(g2,
                -150.0f, -10.0f,                //y1  left vertical center, how much it sways up and down on left side
                10.0f, -10.0f,                //y2  right vertical center, how much it sways up and down on right side

                width / 2.0f - 40.0f, 40.0f,  //cx1 no idea what these do
                0.0f, +5.0f,                  //cy1 increasing first number makes it wavier, deflection of left-most hump

                width / 2.0f + 40, 40.0f,      //cx2
                0.0f, 5.0f,                   //cy2 , same as cy1, but corresponds to right hump

                250.0f, 20.0f, false);          //thickness, speed, invert  big is big, big is slow, boolean can flip whole thing
        
        g2.setRenderingHints(oldHints);
    }

    protected void drawCurve(Graphics2D g2,
            float y1, float y1_offset,
            float y2, float y2_offset,

            float cx1, float cx1_offset,
            float cy1, float cy1_offset,

            float cx2, float cx2_offset,
            float cy2, float cy2_offset,

            float thickness,
            float speed,
            boolean invert) {
        float width = getWidth();
       
        float offset = (float) Math.sin(counter / (speed * Math.PI));
        
        float start_x = 0.0f;
        float start_y = offset * y1_offset + y1;
        float end_x = width;
        float end_y = offset * y2_offset + y2;
        
        float ctrl1_x = offset * cx1_offset + cx1;
        float ctrl1_y = offset * cy1_offset + cy1;
        float ctrl2_x = offset * cx2_offset + cx2;
        float ctrl2_y = offset * cy2_offset + cy2;
       
        GeneralPath thickCurve = new GeneralPath();
        thickCurve.moveTo(start_x, start_y);
        thickCurve.curveTo(ctrl1_x, ctrl1_y,
                ctrl2_x, ctrl2_y,
                end_x, end_y);
        thickCurve.lineTo(end_x, end_y + thickness);
        thickCurve.curveTo(ctrl2_x, ctrl2_y + thickness,
                ctrl1_x, ctrl1_y + thickness,
                start_x, start_y + thickness);
        thickCurve.lineTo(start_x, start_y);
       
        Rectangle bounds = thickCurve.getBounds();
        if (!bounds.intersects(g2.getClipBounds())) {
            return;
        }
      
        GradientPaint painter = new GradientPaint(0, bounds.y,
                invert ? end : start,
                0, bounds.y + bounds.height,
                invert ? start : end);

        Paint oldPainter = g2.getPaint();
        g2.setPaint(painter);
        g2.fill(thickCurve);
       
        g2.setPaint(oldPainter);
    }
}

