// AP(r) Computer Science Marine Biology Simulation:
// The MBSGUI class is copyright(c) 2002 College Entrance
// Examination Board (www.collegeboard.com).
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

/**
 *  AP&reg; Computer Science Marine Biology Simulation:<br>
 *  The <code>MBSGUI</code> class provides a main method for a version
 *  of the AP Computer Science Marine Biology Simulation with a graphical
 *  user interface.
 *
 *  <p>
 *  This class will NOT be tested on the Advanced Placement exam.
 *
 *  <p>
 *  The <code>MBSGUI</code> class is
 *  copyright&copy; 2002 College Entrance Examination Board
 *  (www.collegeboard.com).
 *
 *  @author Alyce Brady
 *  @author Chris Nevison
 *  @author Julie Zelenski
 *  @version 1 July 2002
 *  @see DisplayMap
 *  @see MBSGUIFrame
 **/
 
 
///////////////////////////////////////////////////////////////////////////////////
//  Slightly altered 06-06-03 by Leon Schram
//  This file is meant for three fishes.
/////////////////////////////////////////////////////////////////////////////////// 


public class MBSGUI3
{
    /** Start the Marine Biology Simulation program.
     *  The String arguments (args) are not used in this application.
     **/
   	public static void main(String[] args)
    {
        // Specify which fish classes are available.  This array is used
        // to provide a choice of fish classes in the pull-down menu when
        // manually placing objects into the environment.
        String[] fishClassNames = {"Fish", "DarterFish", "SlowFish"};

        // Specify classes that know how to draw various environment objects;
        // in other words, map environment object classes (like Fish) to
        // display objects (like the FishDisplay object).
        DisplayMap.associate("Fish",new FishDisplay());
        DisplayMap.associate("DarterFish",new LittleFishDisplay());
        DisplayMap.associate("SlowFish",new FishImageDisplay("smallfish.gif",Direction.EAST));

        // Determine what classes are available for representing bounded
        // and unbounded environments.
        String[] boundedClassNames = {"BoundedEnv"};
        String[] unboundedClassNames = {"UnboundedEnv"};

        // Inform the factory object of the classes being used in this program
        // so it can construct instances of those classes when environments
        // are read or created.
        MBSFactory.addEnvObjClassNames(fishClassNames);
        MBSFactory.addBoundedEnvClassNames(boundedClassNames);
        MBSFactory.addUnboundedEnvClassNames(unboundedClassNames);

        // Create and show the window containing the graphical user interface
        MBSGUIFrame guiFrame = new MBSGUIFrame();
        guiFrame.setVisible(true);
    }
}

