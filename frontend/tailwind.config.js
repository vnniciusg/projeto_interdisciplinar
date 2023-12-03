export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    mode: "jit",
    extend: {
      fontFamily: {
        body: ['Inter', 'sans-serif'],
        global: ['Poppins', 'sans-serif']
      },
      colors: {
        primary: "#242424",
        secondary: "#EE5E3B",
        tertiary: "#6D9886",
        text: "#757575",
        title: "#495057"
      }
    },
  },
  plugins: [],
}