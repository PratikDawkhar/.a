#!/bin/bash

# Source base directory
SRC_DIR="/bin/.a/"

# Destination directory (home directory)
DEST_DIR="$HOME/"

# Step 1: Select semester or year (sem 5, sem 6, or sy)
echo "Select a semester or year:"
select SEMESTER in "sem 5" "sem 6" "sy"; do
    if [ -n "$SEMESTER" ]; then
        echo "You have selected: $SEMESTER"
        break
    else
        echo "Invalid selection. Please try again."
    fi
done

# Step 2: Select a directory within the chosen semester/year
if [[ "$SEMESTER" == "sy" ]]; then
    # For sy, select between dsa1 and dsa2
    echo "Select a directory in sy:"
    select DIRECTORY in "$SRC_DIR/sy/dsa1" "$SRC_DIR/sy/dsa2"; do
        if [ -n "$DIRECTORY" ]; then
            echo "You have selected: $DIRECTORY"
            break
        else
            echo "Invalid selection. Please try again."
        fi
    done
else
    # For sem 5 and sem 6, select between os, java, and wt
    echo "Select a directory in $SEMESTER:"
    select DIRECTORY in "$SRC_DIR/$SEMESTER/os" "$SRC_DIR/$SEMESTER/java" "$SRC_DIR/$SEMESTER/wt"; do
        if [ -n "$DIRECTORY" ]; then
            echo "You have selected: $DIRECTORY"
            break
        else
            echo "Invalid selection. Please try again."
        fi
    done
fi

# Step 3: Copy the selected directory or file to the home directory
cp -rf "$DIRECTORY" "$DEST_DIR"

# Step 4: Set 777 permissions on the copied file or directory
CHOSEN_NAME=$(basename "$DIRECTORY")  # Extract the name of the copied item
chmod -R 777 "$DEST_DIR/$CHOSEN_NAME"

# Step 5: Check if both the copy and permission change were successful
if [ $? -eq 0 ]; then
    echo "Directory successfully copied to $DEST_DIR and permissions set to 777."
else
    echo "Error occurred during copying or setting permissions."
fi
