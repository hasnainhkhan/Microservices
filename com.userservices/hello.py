from PIL import Image, ImageDraw, ImageFont

# Create a blank image with white background
image = Image.new('RGB', (200, 100), 'white')
draw = ImageDraw.Draw(image)

# Define the text and font
text = "Hello Git"
font = ImageFont.load_default()

# Calculate the position to center the text
text_width, text_height = draw.textsize(text, font)
position = ((200 - text_width)  2, (100 - text_height)  2)

# Draw the text on the image
draw.text(position, text, fill=black, font=font)

# Save the image
image.save('hello_git.png')

# Show the image
image.show()