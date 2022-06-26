import SwiftUI
import shared

struct ContentView: View {
    @State var name:String = ""
    @State var phoneNo:String = ""
    var body: some View {
        ScrollView(.vertical){
            VStack{
                Text("Phone Note App")
                    .font(.headline)
                    .foregroundColor(.black)
                    .padding(.bottom)
                
                CommonTextFieldView(placeholder: "Enter Name",name: $name)
                
                CommonTextFieldView(placeholder:"Enter phone number",name:$phoneNo)
                
                CommonButton()
                
                Text("List of Phone Numbers")
                    .padding(.top)
                    .font(.subheadline)
                    .foregroundColor(.black)
                EachRow()
            }
        }.padding(20)
    }
}

struct EachRow : View {
    var body: some View{
        ZStack(alignment:.leading) {
            RoundedRectangle(cornerRadius: 25, style: .continuous)
                .fill(.white)
            
            VStack() {
                Text("Name")
                    .font(.largeTitle)
                    .foregroundColor(.black)
                
                Text("8826281048")
                    .font(.title)
                    .foregroundColor(.gray)
            }.padding(20.0)
        }
    }
}

struct CommonTextFieldView : View{
    var placeholder:String
    @Binding var name:String
    var body: some View{
        
        TextField(placeholder,text: $name)
            .padding(.bottom)
            .textFieldStyle(RoundedBorderTextFieldStyle())
            .foregroundColor(.black)
        
        
    }
}

struct CommonButton : View{
    var body: some View{
        
        Button("SAVE"){
            
        }.frame(width: 200, height:50.0)
            .foregroundColor(.white)
            .background(Color.blue)
            .cornerRadius(8.0)
        
    }
}



struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
